const profilePhoto = document.getElementById("profile-photo");
const editPhotoButton = document.getElementById("edit-photo-button");
const editProfileInput = document.getElementById("edit-photo-input");

const activeDonateBtn = document.getElementById("active-donate-btn");

const editPhotoHandler = () => {
  editProfileInput.click();
};

const onInputChangeHandler = async (event) => {
  const f = event.target.files[0];
  const res = await uploadFile(f);

  if (res) {
    profilePhoto.src = res;
    const cookies = getCookies();
    updateUserDp({ dp: res, id: cookies.userid });
  }
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
