const API_URL = "http://localhost:3000/api";

const updateStatus = async ({ type, id, status }) => {
  const reqOptions = {
    method: "PUT",
    body: JSON.stringify({ id, status }),
    headers: {
      "Content-Type": "application/json",
    },
  };

  const resA = await fetch(`${API_URL}/${type}/status`, reqOptions);
  const response = await resA.json();

  return response?.success;
};
