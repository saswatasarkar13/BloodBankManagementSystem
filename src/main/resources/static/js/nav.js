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

const checkUser = () => {
  const cookies = getCookies();

  if (!cookies) return;

  const profileBtn = document.getElementById("profile-btn");
  const registerBtn = document.getElementById("register-btn");
  const loginBtn = document.getElementById("login-btn");
  const logoutBtn = document.getElementById("logout-btn");

  //   console.log({ profileBtn, registerBtn, loginBtn, logoutBtn });

  if (cookies.userid) {
    registerBtn.style.display = "none";
    loginBtn.style.display = "none";

    const username = cookies.username
      ? cookies.username.split("+").join(" ")
      : "Profile";
    $("#profile-btn a").text(username);

    return;
  }

  if (!cookies.userid) {
    logoutBtn.style.display = "none";
    profileBtn.style.display = "none";
  }
};

window.onload = checkUser;
