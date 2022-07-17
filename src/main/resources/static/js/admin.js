const successMsg = {
  text: "Your request is successful!",
  icon: "success",
};

const errorMsg = {
  text: "Sorry, Something went wrong!",
  icon: "error",
};

const handleStatus = async (event, status) => {
  const target = event.target;
  const id = target.getAttribute("data-id");
  const type = target.getAttribute("data-type");

  const response = await updateStatus({ type, id, status });

  if (response) {
    swal(successMsg).then(() => window.location.reload());
    return;
  }

  swal(errorMsg);
};

const handleAdmin = async (event, status) => {
  const target = event.target;
  const id = target.getAttribute("data-id");

  const response = await updateAdminStatus({ id, status });

  if (response) {
    swal(successMsg).then(() => window.location.reload());
    return;
  }

  swal(errorMsg);
};

$(".complete-btn").click((e) => handleStatus(e, "completed"));
$(".cancel-btn").click((e) => handleStatus(e, "cancelled"));

$(".make-admin-btn").click((e) => handleAdmin(e, true));
$(".remove-admin-btn").click((e) => handleAdmin(e, false));

/* ----------------  blood table -------------------- */

const getCity = () => {
  const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
  });

  return params.city;
};

const updateQuantityHandler = async (event) => {
  try {
    const bloodGroup = event.target.getAttribute("data-input-id");

    const input = document.getElementById(bloodGroup);
    if (!input?.value) return;

    const quantity = Number(input.value);
    const city = getCity();
    // console.log({ city, bloodGroup, quantity });
    const response = await updateBloodTable({ city, bloodGroup, quantity });
    if (response) {
      swal(successMsg).then(() => window.location.reload());
      return;
    }
    swal(errorMsg);
  } catch (err) {
    console.log(err);
  }
};

$(".update-blood-quantity-btn").click(updateQuantityHandler);

/* ----------- Donation center ------------- */

const deleteCenterHandler = async (event) => {
  try {
    const id = event.target.getAttribute("data-id");

    const response = await deleteDonationCenter({ id });
    if (response) {
      swal(successMsg).then(() => window.location.reload());
      return;
    }
    swal(errorMsg);
  } catch (err) {
    console.log(err);
    swal(errorMsg);
  }
};

$(".delete-center-btn").click(deleteCenterHandler);
