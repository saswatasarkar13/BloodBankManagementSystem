const getQueryParams = () => {
  const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
  });

  return params;
};

const checkRegister = () => {
  const params = getQueryParams();

  if (params.register) {
    const msg = document.getElementById("successful-register-msg");

    msg.style.display = "block";
  }
};

window.addEventListener("load", checkRegister);
