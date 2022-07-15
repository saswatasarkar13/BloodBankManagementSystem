const API_URL = "http://localhost:3000/api";

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

const onChangeHandler = (event) => {
  console.log(event);
};

const fileInput = document.getElementById("fileInput");

fileInput.addEventListener("change", onChangeHandler);
