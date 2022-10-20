/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
//XOÁ THUỐC
function deleteMedicine(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}

//LẤY THUỐC
function getMedicines(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myMedicine");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td>${i + 1}</td>
                        <td>${data[i][1]}</td>
                        <td>${data[i][2]}</td>
                        <td>${data[i][3]}</td>
                        <td>${data[i][4]}</td>
                        <td><button class="btn">DETAILS</button></td>
                        <td><a href="/Web_QuanLyPhongMach/admins/medicinesManager/${data[i][0]}">Sửa</a></td>
                        <td>
                            <div class="spinner-border text-warning" style="display:none" id="load${data[i][0]}"></div>
                            <button class="btn" style="background-color: #FFCDCD" onclick="deleteMedicine('${endpoint + "/" + data[i][0]}', ${data[i][0]}, this)">DELETE</button>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    })
}

//
////THÊM THUỐC (CHECK VALIDATE)
const name = document.getElementById('name');

const btnAdd = document.getElementById('btnAdd');
const input = document.querySelectorAll('.input-row');

var temp = 0;
btnAdd.addEventListener('click', function () {
    Array.from(input).map((ele) =>
        ele.classList.remove('error')
    );
    let flag = checkValidate();
    //nếu còn lỗi --> không load lại trang
    if (!flag) {
        $(document).ready(function () {
            $('#myF').submit(function (e) {
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
        alert('Gửi đăng ký thành công 1!');
        window.location = "/Web_QuanLyPhongMach/admins/medicinesManager";
    }
    else
    if (flag && temp === 0)
    {
        alert('Gửi đăng ký thành công 2');
        window.location = "/Web_QuanLyPhongMach/admins/medicinesManager";
    }
        
});


function checkValidate() {
    let nameValues = name.value;

    let isCheck = true;

    // Kiểm tra tên
    if (nameValues === '') {
        setError(name, 'Tên thuốc không được để trống!');
        isCheck = false;
    }

    return isCheck;
}

function setError(err, message) {
    let parentEle = err.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}





