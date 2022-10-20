/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/Gruntfile.js to edit this template
 */

/* global axios */

const firstName = document.getElementById('firstName');
const lastName = document.getElementById('lastName');
const email = document.getElementById('email');
const phone = document.getElementById('phoneNumber');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');
const dateOfBirth = document.getElementById('birthday');

const btnSubmit = document.getElementById('btnRegister');
const input = document.querySelectorAll('.input-row');


btnSubmit.addEventListener('click', function () {
    Array.from(input).map((ele) =>
        ele.classList.remove('error')
    );

    //nếu còn lỗi --> không load lại trang
    if (!checkValidate()) {
        $(document).ready(function () {
            $('form').submit(function (event) {
                $.ajax({
                    method: $(this).attr('method'),
                    url: $(this).attr('action'),
                    data: $(this).serialize()
                });
                event.preventDefault();
            });
        });
    } else {
        fetch('/Web_QuanLyPhongMach/api/phoneNumber').then(function (res) {
            return  res.json();
        }).then(function (data) {
            let check = true;
            for (let i = 0; i < data.length; i++)
                if (data[i] == phone.value) {
                    check = false;
                    setError(phone, 'Số điện thoại đã tồn tại');
                }
            if (check)
                window.location = "/Web_QuanLyPhongMach/login";
        });
    }
});


function checkValidate() {
    let firstNameValues = firstName.value;
    let lastNameValues = lastName.value;
    let emailValues = email.value;
    let phoneValues = phone.value;
    let passwordValues = password.value;
    let confirmPasswordValues = confirmPassword.value;
    let dateOfBirthValues = dateOfBirth.value;

    var todayCheck = new Date();
    todayCheck.setDate(todayCheck.getDate() - 1);
    var dateOfBirthCheck = new Date(dateOfBirthValues);

    let isCheck = true;

    // Kiểm tra họ và tên
    if (firstNameValues === '') {
        setError(firstName, 'Họ và tên đệm không được để trống!');
        isCheck = false;
    }
    if (lastNameValues === '') {
        setError(lastName, 'Tên không được để trống');
        isCheck = false;
    }

    //Kiểm tra mật khẩu
    if (passwordValues === '') {
        setError(password, 'Mật khẩu không được để trống');
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

    // Kiểm tra email
    if (emailValues !== "") {
        if (!isEmail(emailValues)) {
            setError(email, 'Email không đúng định dạng');
            isCheck = false;
        }
    }

    // Kiểm tra phoneNumber
    if (phoneValues === '') {
        setError(phone, 'Số điện thoại không được để trống');
        isCheck = false;
    } else if (!isPhone(phoneValues)) {
        setError(phone, 'Số điện thoại không đúng định dạng');
        isCheck = false;
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


