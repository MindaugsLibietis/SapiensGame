function validateName() {
    let x = document.forms["nameValid"]["name"].value;
    if (x == '') {
        alert("Player Name must be filled out");
    return false;
    }
};

/*function validateNumbers() {
    let x = document.forms["numberValid"]["digit1"]["digit2"]["digit3"]["digit4"].value;
    if (x < 0 || x >= 10) {
        alert("Make sure that your input is between 0 and 9");
        return false;
    }
}*/

function validateNumbers() {
  // Get the value of the input field with id="numb"
  let x = document.forms["numberValid"]["digit1"]["digit2"]["digit3"]["digit4"].value;
  // If x is Not a Number or less than one or greater than 10
  let text;
  if (isNaN(x) || x < 1 || x > 10) {
    text = "Input not valid";
  } else {
    text = "Input OK";
  }
  document.forms["numberValid"].innerHTML = text;
}