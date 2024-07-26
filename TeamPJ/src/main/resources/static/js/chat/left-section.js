// 토큰받아옴
function getCsrfToken() {
    return document.querySelector('input[name="_csrf"]').value;
}

// 채팅방 클릭 했을 때
function view_chat(){

}

// 사람 리스트 클릭 했을 때 방 생성
document.querySelectorAll('.people-list .chat-item').forEach(userBtn => {
    userBtn.onclick = () => {
        console.log('딸깍')
        const employeeId = userBtn.id;
        console.log(employeeId)
        fetch('/room', {
            method: "POST",
            headers: {
                'X-CSRF-TOKEN': getCsrfToken(),
                "Content-Type": "application/json"
            },
            body: JSON.stringify({employeeId: employeeId})
        })
            .then(response => {
                if (response.status === 201) {
                    location.reload();
                }
            });
    }
});