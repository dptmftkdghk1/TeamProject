const plus = document.querySelector("input[type=button]");
const content = document.querySelector("textarea");
const text = document.querySelectorAll("span");
const registerBtn = document.getElementById("register");

registerBtn.onClick = () => {

}

plus.onclick = () => {
    content.readOnly = false;
    content.focus();
}

text.forEach(element => {
    element.parentElement.onclick = () => {
        content.blur();
        content.readOnly = true;
    };
});
