// 빈 칸에 대한 이벤트 처리
/*
function validateForm() {
    const fieldIds = ['employeeId', 'employeePassword', 'employeePassword2', 'employeeName','employeeBirthDate'];
    let isValid = true;

    for (let i = 0; i < fieldIds.length; i++) {
        const fieldValue = document.getElementById(fieldIds[i]).value.trim();

        switch (fieldIds[i]) {
            case 'employeeId':
                if (fieldValue === '') {
                    alert('아이디를 입력해주세요.');
                    isValid = false;
                }
                break;
            case 'employeePassword':
                if (fieldValue === '') {
                    alert('비밀번호를 입력해주세요.');
                    isValid = false;
                }
                break;
            case 'employeePassword2':
                if (fieldValue === '') {
                    alert('비밀번호를 재입력해주세요.');
                    isValid = false;
                }
                break;
            case 'employeeName':
                if (fieldValue === '') {
                    alert('이름을 입력해주세요.');
                    isValid = false;
                }
                break;
            case 'employeeBirthDate':
                if (fieldValue === '') {
                    alert('생년월일을 입력해주세요.');
                    isValid = false;
                }
        }
        if (!isValid) {
            break;
        }
    }
    return isValid;
}
*/


// birthdate 형식 처리
const employeeBirthDateInput = document.getElementById('employeeBirthDate');

employeeBirthDateInput.addEventListener('keyup', function() {
    let inputValue = this.value.replace(/\D/g, '');

    if (inputValue.length > 4) {
        inputValue = inputValue.substring(0, 4) + '-' + inputValue.substring(4, 6) + '-' + inputValue.substring(6, 8);
    } else if (inputValue.length > 6) {
        inputValue = inputValue.substring(0, 6) + '-' + inputValue.substring(6, 8);
    }
    this.value = inputValue;
});

// hidden phone 처리



// 휴대폰 인증

IMP.init("imp24111301");
const certificationBtn = document.getElementById('join-admin-button');
const impUid = document.getElementById('imp-uid');
// 본인 인증
certificationBtn.onclick = () => {
    console.log('클릭됨');
    IMP.certification(
        {
            // param
            pg: "inicis_unified.MIIiasTest", //본인인증 설정이 2개이상 되어 있는 경우 필수
        },
        function (rsp) {
            // callback
            console.log(rsp);
            if (rsp.success) {
                // 인증 성공 시 로직
                impUid.value = rsp["imp_uid"];
                certificationBtn.textContent = "본인 인증 완료";
                certificationBtn.disabled = true;


                const phone = rsp.phone;
                console.log(phone);
            } else {
                // 인증 실패 시 로직
                alert("본인 인증 완료 못함");
            }
        },
    );
}

