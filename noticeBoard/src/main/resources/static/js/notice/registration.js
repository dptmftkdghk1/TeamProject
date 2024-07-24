const registerBtn = document.querySelector('.object-manage-button-register');
const updateBtn = document.querySelector('.object-manage-button-modify');
const cancelBtn = document.querySelector('.object-manage-button-cancel');

registerBtn.addEventListener('click', (e) => {
    e.preventDefault();
    const notice = getNoticeFromForm();
    registerObject.POST(notice);
});

updateBtn.addEventListener('click', (e) => {
    e.preventDefault();
    const notice = getNoticeFromForm();
    const noticeId = document.querySelector('input[name="boardNo"]').value;
    registerObject.PUT(noticeId, notice);
});

cancelBtn.addEventListener('click', () => {
    window.location.href = '/notice';
});

const registerObject = {
    "POST": function (notice) {
        fetch(`/notice`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(notice)
        }).then(response => {
            if (response.status === 201) {
                alert('등록이 완료되었습니다!');
                window.location.href = '/notice';
            }
        });
    },
    "PUT": function (id, notice) {
        fetch(`/notice/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(notice)
        }).then(response => {
            if (response.status === 200) {
                alert('수정이 완료되었습니다!');
                window.location.href = '/notice';
            } else if (response.status === 204) {
                alert('해당 정보는 존재하지 않습니다.');
            }
        });
    }
};

function getNoticeFromForm() {
    return {
        boardTitle: document.querySelector('input[name="boardTitle"]').value,
        boardContent: document.querySelector('textarea[name="boardContent"]').value
    };
}


