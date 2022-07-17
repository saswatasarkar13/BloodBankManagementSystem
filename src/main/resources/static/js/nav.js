const checkUser = () => {
  const cookies = getCookies();

  if (!cookies) return;

  const profileBtn = document.getElementById("profile-btn");
  const registerBtn = document.getElementById("register-btn");
  const loginBtn = document.getElementById("login-btn");
  const logoutBtn = document.getElementById("logout-btn");

  const navDonationLi = document.getElementById("nav-donation-li");
  const navProcureLi = document.getElementById("nav-procure-li");
  const navDashboardLi = document.getElementById("nav-dashboard-li");

  //  console.log({ profileBtn, registerBtn, loginBtn, logoutBtn });

  if (!profileBtn || !registerBtn || !loginBtn) {
    return;
  }

  if (cookies.userid) {
    registerBtn.style.display = "none";
    loginBtn.style.display = "none";

    const username = cookies.username
      ? cookies.username.split("+").join(" ")
      : "Profile";
    $("#profile-btn a").text(username);

    if (cookies.role === "admin") {
      navDonationLi.style.display = "none";
      navProcureLi.style.display = "none";
      navDashboardLi.style.display = "block";
    }

    return;
  }

  if (!cookies.userid) {
    logoutBtn.style.display = "none";
    profileBtn.style.display = "none";
  }
};

window.onload = checkUser;
