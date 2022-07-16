const API_URL = "http://localhost:3000/api";

const fileInput = document.getElementById("fileInput");
const dpInput = document.getElementById("dpInput");
const dp = document.getElementById("dp");
const editIcon = document.getElementById("edit-icon");

const uploadFile = async (file) => {
  const formData = new FormData();
  formData.append("file", file);

  const reqOptions = {
    method: "POST",
    body: formData,
  };

  const resA = await fetch(`${API_URL}/user/dp`, reqOptions);
  const response = await resA.json();

  if (response?.success) {
    return response.filepath;
  }

  return null;
};

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

editIcon.addEventListener("click", onClickHandler);

fileInput.addEventListener("change", onChangeHandler, false);
