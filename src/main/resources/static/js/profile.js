const profilePhoto = document.getElementById("profile-photo");
const editPhotoButton = document.getElementById("edit-photo-button");
const editProfileInput = document.getElementById("edit-photo-input");

const activeDonateBtn = document.getElementById("active-donate-btn");

const loader = document.getElementById("loader");

const editPhotoHandler = () => {
  editProfileInput.click();
};

const onInputChangeHandler = async (event) => {
  const f = event.target.files[0];

  if (!f) return;

  if (f.size > 1024 * 1024 * 2) {
    // 2MB
    swal({
      text: "File size too large!",
      icon: "info",
    });

    return;
  }

  if (loader) loader.style.display = "block";

  const fname = Date.now() + "-" + f.name;
  const res = await uploadFileToFirebaseBucket(f, fname);

  if (res) {
    const cookies = getCookies();
    const success = updateUserDp({ dp: encodeURI(res), id: cookies.userid });
    if (success) profilePhoto.src = res;
  }

  if (loader) loader.style.display = "none";
};

editPhotoButton.addEventListener("click", editPhotoHandler);

editProfileInput.addEventListener("change", onInputChangeHandler, false);

const activeDonateHandler = (event) => {
  const target = event.target;
  const value = target.getAttribute("data-value") === "true";

  const cookies = getCookies();
  updateDonateStatus({ status: !value, id: cookies.userid });

  if (value) {
    target.className = "btn btn-success";
    target.innerText = "Start Actively Donating";
  } else {
    target.className = "btn btn-outline-success";
    target.innerText = "Actively Donating";
  }

  event.target.setAttribute("data-value", !value);
};

if (activeDonateBtn)
  activeDonateBtn.addEventListener("click", activeDonateHandler);
