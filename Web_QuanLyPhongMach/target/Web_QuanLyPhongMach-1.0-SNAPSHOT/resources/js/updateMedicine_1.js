/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


//SỬA THUỐC
const mName = document.getElementById('mName');
const mUnitPrice = document.getElementById('mUnitPrice');
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
        alert('Sửa thành công 1!');
        location.reload(true);
    }

    if (flag && t === 0) {
        alert('Sửa thành công 2');
        location.reload(true);
    }
});


function checkValidateForUpdate() {
    let mNameValues = mName.value;
    let mUnitPriceValues = mUnitPrice.value;
    
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
    }

    return isCheck;
}