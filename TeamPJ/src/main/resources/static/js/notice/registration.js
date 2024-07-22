const registerBtn = document.getElementsByClassName('object-manage-button-register');
const updateBtn = document.getElementsByClassName('object-manage-button-modify');
const cancelBtn = document.getElementsByClassName('object-manage-button-cancel');
const registrationList = document.getElementsByClassName('rental-table-list-footer')
const imageBtn = document.getElementsByClassName('')


updateBtn.onclick = () => {
    if(boardTitle.value !== undefined && boardTitle.value !== ''){
        const notice = {
            boardNo: boardNo.value,
            boardTitle: boardTitle.value,
            boardContent: boardContent.value
        };
        requestObject.PUT(notice);
    }
    else if( /^[0-9]+$/.test(boardContent.value) ){
        requestObject.PATCH();
    }
}

requestObject.PUT = function (notice){
    fetch(`/notice/${board.value}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(notice)
    }).then(response => {
        if(response.status === 200){
            alert('수정이 완료되었습니다!');
            requestObject.GET_ALL();
        }
        else if(response.status === 204){
            alert('해당 책 정보는 존재하지 않습니다..');
        }
    });
}
