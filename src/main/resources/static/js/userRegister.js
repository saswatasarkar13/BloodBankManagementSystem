const fileInput = document.getElementById("fileInput");
const dpInput = document.getElementById("dpInput");
const dp = document.getElementById("dp");
const editIcon = document.getElementById("edit-icon");

const onClickHandler = () => {
  fileInput.click();
};

const onChangeHandler = async (event) => {
  const f = event.target.files[0];
  const res = await uploadFile(f);

  if (res) {
    dpInput.value = res;
    dp.src = res;
  }
};

if (editIcon) editIcon.addEventListener("click", onClickHandler);

if (fileInput) fileInput.addEventListener("change", onChangeHandler, false);
