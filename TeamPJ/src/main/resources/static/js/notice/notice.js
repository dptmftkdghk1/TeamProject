const registerBtn = document.getElementsByClassName('registration');
const delBtn = document.getElementsByClassName('delete');
const searchBtn = document.getElementsByClassName('rental-searchBtn');

const requestObject = {
    "DELETE": function () {
        fetch(`/notice/${delBtn.value}`, {
            method: "DELETE"
        }).then(response => {
            if (response.status === 200) {
                alert('삭제가 완료되었습니다!');
                requestObject.GET_ALL(); // 전부 재 조회
            } else if (response.status === 204) {
                alert('해당 책 정보는 존재하지 않습니다..');
            }
        });
    }
}