const registerButton = document.querySelector(".login-button");

registerButton.onclick = () => {
    const registerInputs = document.querySelectorAll(".login-input");
    let registerInfo = {
        lastName: registerInputs[0].value,
        firstName: registerInputs[1].value,
        email: registerInpnts[2].value,
        password: registerInputs[3].value
n}

    $.ajax({
        async: false,
        type: "post",
        url: "/api/account/register",
        contentType: "application/json",
        data: JSON.stringify(registerInpnts),
        dataType: "json",
        success: (response) => {
            
        },
        error: (error) => {

        }
    });
}