/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//-------------ĐẶT LỊCH----------------------
function getEmployeeOncal(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myEmployeeOnCall");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td>${i + 1}</td>
                        <td>${data[i][1]} ${data[i][2]}</td>
                        <td>${data[i][3]}</td>
                        <td>${data[i][5]}</td>
                        <td>
                            <div class="spinner-border text-secondary" style="display:none" id="load${data[i][0]}"></div>
                            <button class="btn far fa-calendar-alt" data-bs-toggle="modal" onclick="fonCall('${endpoint}', ${data[i][0]})"></button>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}

//--------------------XOÁ LỊCH ĐẶT-----------------------
function deleteOnCall(endpoint, id, btn) {
    if (confirm("Bạn có chắc chắn xoá?") === true) {
        let r = document.getElementById(`row2${id}`);
        let load = document.getElementById(`load2${id}`);
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
//----------------SHOW LICH----------------------------
function fonCall(endpoint, id) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        for (let i = 0; i < data.length; i++)
            if (data[i][0] == id)
                document.getElementById('employeeId').setAttribute('value', data[i][0]);
    }).catch(function (err) {
        console.error(err);
    });
    $('#addOncall').modal('show');
}

function getOnCall(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myOnCall");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row2${data[i][0]}">
                        <td>${i + 1}</td>
                        <td>${data[i][3]} ${data[i][4]}</td>
                        <td>${data[i][1]} ${data[i][2]}</td>
                        <td>${moment(data[i][5]).format("DD/MM/YYYY")}</td>
                        <td>${data[i][6]}</td>
                        <td>
                            <div class="spinner-border text-warning" style="display:none" id="load2${data[i][0]}"></div>
                            <button class="btn fas fa-trash-alt" data-bs-toggle="modal" onclick="deleteOnCall('${endpoint + "/" + data[i][0]}', ${data[i][0]}, this)"></button>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }
    }).catch(function (err) {
        console.error(err);
    });
}

//----------------------Kiểm Tra Ngày hợp lệ----------------

const date = document.getElementById('date2');

const btnSubmit = document.getElementById('bt-submit');
const input = document.querySelectorAll('.input-row');

var temp = 0;
btnSubmit.addEventListener('click', function () {
    Array.from(input).map((ele) =>
        ele.classList.remove('error'));
    let flag = checkValidate();
    if (!flag) {
        $('#myForm').on('submit', function (e) {
            e.preventDefault(); // Now nothing will happen
        });
        temp++;
    }

    if (flag && temp >= 1)
    {
        $(document).ready(function () {
            $('form').submit(function () {
                $.ajax({
                    method: $(this).attr('method'),
                    url: $(this).attr('action'),
                    data: $(this).serialize()
                });
            });
        });
        alert('Gửi đăng ký thành công  !');
        window.location = "/Web_QuanLyPhongMach/admins/onCallManager";
    }

    console.log(temp);
    if (flag && temp <= 0)
    {
        alert('Gửi đăng ký thành công !');
        window.location = "/Web_QuanLyPhongMach/admins/onCallManager";
    }
});


function checkValidate() {
    
    let dateOfBirthValues = date.value;

    var todayCheck = new Date();
    todayCheck.setDate(todayCheck.getDate() - 1);
    var dateOfBirthCheck = new Date(dateOfBirthValues);

    let isCheck = true;

    if (dateOfBirthValues == "") {
        setError(date, 'Ngày không hợp lệ!');
        isCheck = false;
    }
    // Kiểm tra ngày sinh
    if (dateOfBirthCheck <= todayCheck) {
        setError(date, 'Ngày không hợp lệ!');
        isCheck = false;
    }

    return isCheck;
}

function setError(err, message) {
    let parentEle = err.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}