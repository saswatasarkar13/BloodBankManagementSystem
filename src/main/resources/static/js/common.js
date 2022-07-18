const API_URL = "/api";

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

const getCookies = () => {
  const cookie = document.cookie;

  const output = {};
  cookie.split(/\s*;\s*/).forEach(function (pair) {
    pair = pair.split(/\s*=\s*/);
    const name = decodeURIComponent(pair[0]);
    const value = decodeURIComponent(pair.splice(1).join("="));
    output[name] = value;
  });

  return output;
};
