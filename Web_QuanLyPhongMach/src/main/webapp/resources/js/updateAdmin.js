/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */



//Trường xữ lý lổi của form Add

const firstname = document.getElementById("firstName");
const lastname = document.getElementById("lastName");
const email = document.getElementById("email");
const phone = document.getElementById("phone");
const username = document.getElementById("username");
const dateOfBirth = document.getElementById("dateOfBirth");

const btSubmit = document.getElementById('btnUpdate');
const inputEls = document.querySelectorAll('.input-row');

var temp = 0;
btSubmit.addEventListener('click', function () {
    Array.from(inputEls).map((ele) =>
        ele.classList.remove('error'));

    let flag = checkValidate();
    if (!flag) {
        $(document).ready(function () {
            $('#formUpdate').submit(function (e) {
                e.preventDefault();
            });
        });
        temp++;
    }
    if (flag && temp >= 1)
    {
        var formData = new FormData($('#formUpdate')[0]);
        $(document).ready(function () {
            $('form').submit(function () {
                $.ajax({
                    method: $(this).attr('method'),
                    url: $(this).attr('action'),
                    data: formData,
                    async: false,
                    cache: false,
                    processData: false,
                    contentType: false
                });
            });
        });
        alert('Gửi đăng ký thành công !');
        window.location = "/Web_QuanLyPhongMach/admins/adminsManager";
    }
    if (flag && temp <= 0)
    {
        alert('Gửi đăng ký thành công !!');
    }
});



//Kiểm tra lổi
function checkValidate() {
    let fn = firstname.value;
    let ln = lastname.value;
    let eml = email.value;
    let phn = phone.value;
    let user = username.value;
    let dateOfB = dateOfBirth.value;

    let isCheck = true;

    if (fn === '') {
        setError(firstname, 'Họ và tên đệm không được để trống');
        isCheck = false;
    }

    if (fn.length > 24) {
        setError(firstname, 'Họ và tên đệm không lớn hơn 24 ký tự');
        isCheck = false;
    }

    if (ln === '') {
        setError(lastname, 'Tên không được để trống');
        isCheck = false;
    }

    if (ln.length > 24) {
        setError(lastname, 'Tên không lớn hơn 24 ký tự');
        isCheck = false;
    }

    if (user === '') {
        setError(username, 'Tài khoản không được để trống');
        isCheck = false;
    }

    if (eml === '') {
        setError(email, 'Email không được để trống');
        isCheck = false;
    } else if (!isEmail(eml)) {
        setError(email, 'Email không đúng định dạng');
        isCheck = false;
    }

    if (phn === '') {
        setError(phone, 'Số điện thoại không được để trống');
        isCheck = false;
    } else if (!isPhone(phn)) {
        setError(phone, 'Số điện thoại không đúng định dạng');
        isCheck = false;
    }

    var todayCheck = new Date();
    todayCheck.setDate(todayCheck.getDate() - 1);
    var dateOfBirthCheck = new Date(dateOfB);

    if (dateOfB == "") {
        setError(dateOfBirth, 'Ngày không hợp lệ!');
        isCheck = false;
    }
    // Kiểm tra ngày sinh
    if (dateOfBirthCheck >= todayCheck) {
        setError(dateOfBirth, 'Ngày không hợp lệ!!');
        isCheck = false;
    }

    return isCheck;
}

function setError(e, message) {
    let parentEle = e.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}

//kiểm tra email có hợp lệ
function isEmail(eml) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(eml);
}
//kiểm tra số điẹn thoại có hợp lệ
function isPhone(nb) {
    return /(84|0[3|5|7|8|9])+([0-9]{8})\b/.test(nb);
}


