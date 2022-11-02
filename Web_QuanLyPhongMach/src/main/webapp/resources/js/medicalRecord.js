/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//LẤY PHIẾU KHÁM BỆNH
function getMedicalRecord(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myMedicalRecord");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr>
                        <td>${data[i][0]}</td>
                        <td>${data[i][1]} ${data[i][2]}</td>
                        <td>
                            <a href="/Web_QuanLyPhongMach/employees/prescription/${data[i][0]}">Kê toa thuốc</a>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}


//
const symptom = document.getElementById('symptom');
const conclusion = document.getElementById('conclusion');
const btnSubmit = document.getElementById('btnAdd');
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
        alert('Lập phiếu khám thành công.');
        window.location = "/Web_QuanLyPhongMach/employees/prescription";
    }

    console.log(temp);
    if (flag && temp <= 0)
    {
        alert('Lập phiếu khám thành công.');
        window.location = "/Web_QuanLyPhongMach/employees/prescription";
    }
});


function checkValidate() {
    
    let symptomValues = symptom.value;
    let conclusionValues = conclusion.value;
    

    let isCheck = true;

    if (symptomValues === "") {
        setError(symptom, 'Triệu chứng bệnh không được để trống!');
        isCheck = false;
    }
    
    if (conclusionValues === "") {
        setError(conclusion, 'Kết luận bệnh không được để trống!');
        isCheck = false;
    }

    return isCheck;
}

function setError(err, message) {
    let parentEle = err.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}