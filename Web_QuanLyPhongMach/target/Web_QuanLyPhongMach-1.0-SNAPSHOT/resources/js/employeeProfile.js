/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

//SỬA ADMIN
const firstName = document.getElementById('firstName');
const lastName = document.getElementById('lastName');
const dateOfBirth = document.getElementById('dateOfBirth');
const email = document.getElementById('email');
const phone = document.getElementById('phone');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');

const btnUpdateProfile = document.getElementById('btnUpdateProfile');
const inputRow = document.querySelectorAll('.input-row');

var t = 0;
btnUpdateProfile.addEventListener('click', function () {
    Array.from(inputRow).map((ele) =>
        ele.classList.remove('error')
    );
    let flag = checkValidateForUpdate();

    if (!flag) {
        $(document).ready(function () {
            $('#updateProfileAdmin').submit(function (e) {
                e.preventDefault();
            });
        });
        t++;
    }

    if (flag && t >= 1) {
        var formData = new FormData($('#updateProfileAdmin')[0]);
        $(document).ready(function () {
            $('form').submit(function () {
                $.ajax({
                    method: $(this).attr('method'),
                    url: $(this).attr('action'),
                    processData: false,
                    contentType: false,
                    data: formData
                });
            });
        });
        alert('Sửa thành công1');
    }
    if (flag && t === 0) {
        alert('Sửa thành công2');
    }
});


function checkValidateForUpdate() {
    let firstNameValue = firstName.value;
    let lastNameValue = lastName.value;
    let dateOfBirthValue = dateOfBirth.value;
    let phoneValue = phone.value;
    let emailValue = email.value;
    let passwordValues = password.value;
    let confirmPasswordValues = confirmPassword.value;

    var todayCheck = new Date();
    todayCheck.setDate(todayCheck.getDate() - 1);
    var dateOfBirthCheck = new Date(dateOfBirthValue);

    let isCheck = true;

    // Kiểm tra tên
    if (firstNameValue === '') {
        setError(firstName, 'Họ và tên đệm không được để trống!');
        isCheck = false;
    }
    if (lastNameValue === '') {
        setError(lastName, 'Tên không được để trống!');
        isCheck = false;
    }

    // Kiểm tra email
    if (emailValue !== "") {
        if (!isEmail(emailValue)) {
            setError(email, 'Email không đúng định dạng');
            isCheck = false;
        }
    }

    // Kiểm tra phoneNumber
    if (phoneValue === '') {
        setError(phone, 'Số điện thoại không được để trống');
        isCheck = false;
    } else if (!isPhone(phoneValue)) {
        setError(phone, 'Số điện thoại không đúng định dạng');
        isCheck = false;
    }
    
    if (confirmPasswordValues === '') {
        setError(confirmPassword, 'Xác nhận mật khẩu không được để trống');
        isCheck = false;
    }
    
    if (passwordValues !== '' && confirmPasswordValues !== '') {
        if (passwordValues !== confirmPasswordValues) {
            setError(confirmPassword, 'Mật khẩu không khớp');
            isCheck = false;
        }
    }
    // Kiểm tra ngày sinh
    if (dateOfBirthCheck >= todayCheck) {
        setError(dateOfBirth, 'Ngày sinh không hợp lệ!');
        isCheck = false;
    }

    return isCheck;
}


function setError(err, message) {
    let parentEle = err.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}

function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function isPhone(number) {
    return /(84|0[3|5|7|8|9])+([0-9]{8})\b/.test(number);
}

