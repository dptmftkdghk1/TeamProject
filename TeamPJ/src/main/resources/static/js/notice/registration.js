const registerBtn = document.getElementsByClassName('object-manage-button-register');
const updateBtn = document.getElementsByClassName('object-manage-button-modify');
const cancelBtn = document.getElementsByClassName('object-manage-button-cancel');


const registerObject = {
    "POST": function (notice){
        fetch(`/notice`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(notice)
        }).then(response => {
            if(response.status === 201){
                alert('등록이 완료되었습니다!');
                registerObject.GET_ALL();
            }
        })
    },
    "PUT": function (notice){
        fetch(`/notice/${isbnInput.value}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(notice)
        }).then(response => {
            if(response.status === 200){
                alert('수정이 완료되었습니다!');
                registerObject.GET_ALL(); // 전부 재 조회
            }
            else if(response.status === 204){
                alert('해당 책 정보는 존재하지 않습니다..');
            }
        });
    }
}
