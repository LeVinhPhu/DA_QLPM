/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//đặt phiếu khám
const quantity = document.getElementById('quantityMedicine');
const btnAddMedicine = document.getElementById('btnAddMedicine');
const input = document.querySelectorAll('.input-row');

var temp = 0;
btnAddMedicine.addEventListener('click', function () {
    Array.from(input).map((ele) =>
        ele.classList.remove('error')
    );

    let flag = checkValidate();
    //nếu còn lỗi --> không load lại trang
    if (!flag) {
        $(document).ready(function () {
            $('#FormAddMedicine').submit(function (e) {
                e.preventDefault();
            });
        });
        temp++;
    }

    if (flag && temp >= 1) {
        $(document).ready(function () {
            $('form').submit(function () {
                $.ajax({
                    method: $(this).attr('method'),
                    url: $(this).attr('action'),
                    data: $(this).serialize()
                });
            });
        });
        location.reload(true);
    }

    if (flag && temp === 0) {
        location.reload(true);
    }
});


function checkValidate() {
    let quantityValues = quantity.value;

    
    let isCheck = true;

    // Kiểm tra số lượng
    if (quantityValues === '') {
        setError(quantity, 'Số lượng không được để trống!');
        isCheck = false;
    } else if (quantityValues < 1) {
        setError(quantity, 'Số lượng phải lớn hơn 0.');
        isCheck = false;
    }

    return isCheck;
}

//SET LỖI
function setError(err, message) {
    let parentEle = err.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}


