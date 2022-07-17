const cityInput = document.getElementById("city");
const submitBtn = document.getElementById("submit-btn");

const onSubmitHandler = async () => {
  const city = cityInput.value;
  const response = await addCity(city);

  if (response) {
    swal({
      text: "Your request is successful!",
      icon: "success",
    }).then(() => window.location.replace("/dashboard"));

    return;
  }

  swal({
    text: "Sorry, Something went wrong!",
    icon: "error",
  });
};

if (submitBtn) submitBtn.addEventListener("click", onSubmitHandler);
