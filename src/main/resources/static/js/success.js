const printBtn = document.getElementById("print-btn");

const printHandler = () => {
  window.print();
};

printBtn.addEventListener("click", printHandler);
