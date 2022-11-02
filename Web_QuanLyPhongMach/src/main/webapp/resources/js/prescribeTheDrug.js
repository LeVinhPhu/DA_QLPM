/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//đặt phiếu khám
const quantity = document.getElementById('quantityMedicine');
const btnAddMedicine = document.getElementById('btnAddMedicine');
const input = document.querySelectorAll('.input-row');
const idMedi = document.getElementById('idMedi');

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
                    data: $(this).serialize(),
                    async: false,
                    cache: false
                });
            });
        });
        window.location = `/Web_QuanLyPhongMach/employees/prescription/${idMedi.value}`;
    }

    if (flag && temp === 0) {
        window.location = `/Web_QuanLyPhongMach/employees/prescription/${idMedi.value}`;
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


//xoá thuốc trong toa thuốc
function deleteMedicineInPre(endpoint, id, btn) {
    if (confirm("Bạn có chắc chắn xoá?") === true) {
        let r = document.getElementById(`row${id}`);
        let load = document.getElementById(`load${id}`);
        load.style.display = "block";
        btn.style.display = "none";
        fetch(endpoint, {
            method: 'delete'
        }).then(function (res) {
            if (res.status !== 204)
                load.style.display = "none";
            r.style.display = "none";
        }).catch(function (err) {
            console.error(err);
            btn.style.display = "block";
            load.style.display = "none";
        });
    }
}

//lấy tất cả thuốc trong toa thuốc
function getMedicineInPrescription(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("MyMedicineInPrescription");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][9]}">
                        <td>${data[i][4]}</td>
                        <td>${data[i][5]}</td>
                        <td>${data[i][6]}</td>
                        <td>${data[i][7].toFixed(0).replace(/\B(?=(\d{3})+(?!\d))/g, '.')}</td>
                        <td>${data[i][8]}</td>
                        <td>
                            <div class="spinner-border text-warning" style="display:none" id="load${data[i][9]}"></div>
                            <i onclick="deleteMedicineInPre('${endpoint + "/" + data[i][9]}', ${data[i][9]}, this)" class="fas fa-minus"></i>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}


