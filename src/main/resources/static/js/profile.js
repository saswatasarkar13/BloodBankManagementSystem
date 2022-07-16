const profilePhoto = document.getElementById("profile-photo");
const editPhotoButton = document.getElementById("edit-photo-button");
const editProfileInput = document.getElementById("edit-photo-input");

const editPhotoHandler = () => {
  editProfileInput.click();
};

const onInputChangeHandler = async (event) => {
  const f = event.target.files[0];
  const res = await uploadFile(f);

  if (res) {
    profilePhoto.src = res;
  }
};

editPhotoButton.addEventListener("click", editPhotoHandler);

editProfileInput.addEventListener("change", onInputChangeHandler, false);
