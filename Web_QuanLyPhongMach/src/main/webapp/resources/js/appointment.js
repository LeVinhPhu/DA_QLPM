/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//LẤY PHIẾU ĐẶT (KHÁCH HÀNG)
function getAppointment(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myAppointment");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td></td>
                        <td>${data[i][0]}</td>
                        <td>${moment(data[i][1]).format("DD/MM/YYYY")}</td>
                        <td>${data[i][2]}</td>
                        <td>${data[i][3]}</td>
                        <td>${data[i][8]}</td>
                        <td>
                            <div class="spinner-border text-warning" style="display:none" id="load${data[i][0]}"></div>
                            <i onclick="deleteAppointment('${endpoint + "/" + data[i][0]}', ${data[i][0]})" class="fas fa-trash-alt"></i>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}


// XOÁ PHIẾU ĐẶT (khách hàng)
function deleteAppointment(endpoint, id) {
    fetch('/Web_QuanLyPhongMach/api/appointment').then(function (res) {
        return  res.json();
    }).then(function (data) {
        a = true;
        for (let i = 0; i < data.length; i++)
            if (data[i][7] === 2 && data[i][0] === id)
            {
                alert("Lịch khám đã được xác nhận! Không thể huỷ!");
                a = false;
            }
        if (a) {
            if (confirm("Bạn có chắc chắn xoá?") === true) {
                fetch(endpoint, {
                    method: 'delete'
                }).then(function (res) {
                    if (res.status === 204)
                        window.location = "/Web_QuanLyPhongMach/customers/appointments";
                    else
                        alert("Something Wrong!!");
                }).catch(function (err) {
                    console.error(err);
                });
                alert("Xoá lịch khám thành công.");
            }
        }
    });
}



//LẤY PHIẾU ĐẶT ĐÃ ĐƯỢC XÁC NHẬN(BÁC SĨ)
function getAppointmentForDoctor(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myAppointmentForDoctor");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td>${data[i][9]}</td>
                        <td>${data[i][5]} ${data[i][6]}</td>
                        <td>
                            <a style="text-decoration: none;" href="/Web_QuanLyPhongMach/employees/medicalRecord/${data[i][4]}"><i class="fas fa-pencil-alt"></i>  Lập Phiếu</a>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}


function getAppointmentForNurse(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();    }).then(function (data) {
        let d = document.getElementById("myAppointmentForNurse");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td>${data[i][0]}</td>
                        <td>${data[i][5]} ${data[i][6]}</td>
                        <td>${moment(data[i][1]).format("DD/MM/YYYY")}</td>
                        <td>${data[i][2]}</td>
                        <td>
                            <input type="radio" id="html" name="idAppointment" value="${data[i][0]}">
                            <label for="html">Chọn</label><br>
                        </td>
                        <td>
                        </td>  
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}


//đặt phiếu khám
const date = document.getElementById('date');
const time = document.getElementById('time');
const btnSubmit = document.getElementById('btnSubmit');
const input = document.querySelectorAll('.input-row');

var temp = 0;
btnSubmit.addEventListener('click', function () {
    Array.from(input).map((ele) =>
        ele.classList.remove('error')
    );

    let flag = checkValidate();
    //nếu còn lỗi --> không load lại trang
    if (!flag) {
        $(document).ready(function () {
            $('#MyFormAppointment').submit(function (e) {
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
        alert('Đặt lịch thành công');
        location.reload(true);
    }

    if (flag && temp === 0) {
        alert('Đặt lịch thành công');
        location.reload(true);
    }
});

function checkValidate() {
    let dateValues = date.value;
    let timeValues = time.value;

    var today = new Date();
    today.setDate(today.getDate() + 1);
    var dateInAppointment = new Date(dateValues);

    let isCheck = true;

    // Kiểm tra ngày
    if (dateValues === '') {
        setError(date, 'Ngày không được để trống!');
        isCheck = false;
    } else if (dateInAppointment < today) {
        setError(date, 'Ngày hẹn không hợp lệ!');
        isCheck = false;
    }

    // Kiểm tra giờ
    if (timeValues === '') {
        setError(time, 'Giờ không được để trống!');
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
