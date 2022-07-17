const updateAdminStatus = async ({ id, status }) => {
  const reqOptions = {
    method: "PUT",
    body: JSON.stringify({ id, status }),
    headers: {
      "Content-Type": "application/json",
    },
  };

  const resA = await fetch(`${API_URL}/user/admin`, reqOptions);
  const response = await resA.json();

  return response?.success;
};

const addCity = async (city) => {
  const reqOptions = {
    method: "POST",
    body: JSON.stringify({ city }),
    headers: {
      "Content-Type": "application/json",
    },
  };

  const resA = await fetch(`${API_URL}/blood/`, reqOptions);
  const response = await resA.json();

  return response?.id;
};

const updateBloodTable = async ({ city, bloodGroup, quantity }) => {
  const reqOptions = {
    method: "POST",
    body: JSON.stringify({ city, bloodGroup, quantity }),
    headers: {
      "Content-Type": "application/json",
    },
  };

  const resA = await fetch(`${API_URL}/blood/group`, reqOptions);
  const response = await resA.json();

  return response?.success;
};
