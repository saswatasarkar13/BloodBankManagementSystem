const fileInput = document.getElementById("fileInput");
const dpInput = document.getElementById("dpInput");
const dp = document.getElementById("dp");
const editIcon = document.getElementById("edit-icon");

const loader = document.getElementById("loader");

const onClickHandler = () => {
  fileInput.click();
};

const onChangeHandler = async (event) => {
  if (loader) loader.style.display = "block";

  const f = event.target.files[0];
  const fname = new Date() + "-" + f.name;

  const res = await uploadFileToFirebaseBucket(f, fname);

  if (res) {
    dpInput.value = res;
    dp.src = res;
  } else {
    swal({
      text: "Sorry, Something went wrong!",
      icon: "error",
    });
  }

  if (loader) loader.style.display = "none";
};

if (editIcon) editIcon.addEventListener("click", onClickHandler);

if (fileInput) fileInput.addEventListener("change", onChangeHandler, false);
