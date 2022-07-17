const printBtn = document.getElementById("print-btn");
const cancelBtn = document.getElementById("cancel-btn");

const printHandler = () => {
  const buttonContainer = document.getElementById("button-container");
  buttonContainer.style.visibility = "hidden";

  window.print();

  buttonContainer.style.visibility = "visible";
};

const cancelHandler = async () => {
  const url = new URL(window.location.href);
  const arr = url.pathname.split("/");

  const response = await updateStatus({
    type: arr[1],
    id: arr[3],
    status: "cancelled",
  });

  if (response) {
    swal({
      text: "Your request is successful!",
      icon: "success",
    }).then(() => window.location.replace(`/${arr[1]}`));

    return;
  }

  swal({
    text: "Sorry, Something went wrong!",
    icon: "error",
  });
};

if (printBtn) printBtn.addEventListener("click", printHandler);

if (cancelBtn) cancelBtn.addEventListener("click", cancelHandler);
