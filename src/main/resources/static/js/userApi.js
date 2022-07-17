const uploadFile = async (file) => {
  const formData = new FormData();
  formData.append("file", file);

  const reqOptions = {
    method: "POST",
    body: formData,
  };

  const resA = await fetch(`${API_URL}/file/upload`, reqOptions);
  const response = await resA.json();

  if (response?.success) {
    return response.filepath;
  }

  return null;
};

const updateUserDp = async (data) => {
  const reqOptions = {
    method: "PUT",
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
    },
  };

  const resA = await fetch(`${API_URL}/user/dp`, reqOptions);
  const response = await resA.json();

  if (!response?.success) {
    swal({
      text: "Sorry, Something went wrong!",
      icon: "error",
    });
  }
};

const updateDonateStatus = (data) => {
  const reqOptions = {
    method: "PUT",
    body: JSON.stringify(data),
  };

  fetch(`${API_URL}/user/active-donation-status`, reqOptions);
};
