/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');

const btSubmit = document.getElementById('btnUpdate');
const inputEls = document.querySelectorAll('.input-row');

var temp = 0;
btSubmit.addEventListener('click', function () {
    Array.from(inputEls).map((ele) =>
        ele.classList.remove('error'));

    let flag = checkValidate();
    if (!flag) {
        $(document).ready(function () {
            $('#formC').submit(function (e) {
                e.preventDefault();
            });
        });
        temp++;
    }
    if (flag && temp >= 1)
    {
        var formData = new FormData($('#formC')[0]);
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
        alert('Lưu mật khẩu thành công!\nThông tin sẽ được cập nhật vào lần đăng nhập tiếp theo');
        window.location = "/Web_QuanLyPhongMach/customers/customersIndex";
    }
    if (flag && temp <= 0)
    {
        alert('Lưu mật khẩu thành công!!\nThông tin sẻ được cập nhật vào lần đăng nhập tiếp theo');
    }
});

//Kiểm tra lổi
function checkValidate() {
    let passwordValues = password.value;
    let confirmPasswordValues = confirmPassword.value;
    let isCheck = true;

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
    return isCheck;
}

function setError(e, message) {
    let parentEle = e.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}
