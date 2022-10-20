/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


//SỬA THUỐC
const mName = document.getElementById('mName');
const mUnitPrice = document.getElementById('mUnitPrice');
const mQuantity = document.getElementById('mQuantity');

const btnUpdate = document.getElementById('btnUpdate');
const inputRow = document.querySelectorAll('.input-row');

var t = 0;
btnUpdate.addEventListener('click', function () {
    Array.from(inputRow).map((ele) =>
        ele.classList.remove('error')
    );
    
    let flag = checkValidateForUpdate();
    
    if (!flag) {
        $(document).ready(function () {
            $('#formUpdate').submit(function (e) {
                e.preventDefault();
            });
        });
        t++;
    }

    if (flag && t >= 1) {
        var formData = new FormData($('#formUpdate')[0]);
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
        alert('Sửa thành công');
        window.location="/Web_QuanLyPhongMach/admins/medicinesManager";
        getMedicines('/Web_QuanLyPhongMach/api/medicines');
    }

    if (flag && t === 0) {
        alert('Sửa thành công');
        window.location="/Web_QuanLyPhongMach/admins/medicinesManager";
        getMedicines('/Web_QuanLyPhongMach/api/medicines');
    }
});


function checkValidateForUpdate() {
    let mNameValues = mName.value;
    let mUnitPriceValues = mUnitPrice.value;
    let mQuantityValues = mQuantity.value;
    
    let isCheck = true;
    
    // Kiểm tra tên
    if (mNameValues === '') {
        setError(mName, 'Tên thuốc không được để trống!');
        isCheck = false;
    }
    
    // Kiểm tra đơn giá
    if (mUnitPriceValues === '') {
        setError(mUnitPrice, 'Đơn giá không được để trống!');
        isCheck = false;
    } else if (mUnitPriceValues < 0) {
        setError(mUnitPrice, 'Đơn giá không hợp lệ!');
        isCheck = false;
    }

    // Kiểm tra số lượng
    if (mQuantityValues < 0) {
        setError(mQuantity, 'Số lượng phải lớn hơn hoặc bằng 0!');
        isCheck = false;
    }
    
    return isCheck;
}



function setError(err, message) {
    let parentEle = err.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}
