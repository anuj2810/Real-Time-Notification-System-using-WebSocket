let stompClient = null;

document.addEventListener('DOMContentLoaded', () => {
    // Check initial state
    updateConnectionState(false);
});

function useDemoUser() {
    const randomId = 'user_' + Math.floor(Math.random() * 1000);
    document.getElementById('userId').value = randomId;
}

function connect() {
    const userIdInput = document.getElementById('userId');
    const userId = userIdInput.value.trim();

    if (!userId) {
        showStatus('Please enter a User ID', 'error');
        userIdInput.focus();
        return;
    }

    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    // Disable debug logs for cleaner console
    stompClient.debug = () => { };

    stompClient.connect({ login: userId }, (frame) => {
        updateConnectionState(true, userId);
        showStatus('Connected successfully', 'success');

        // Subscribe to personal notifications
        stompClient.subscribe("/user/queue/notifications", (message) => {
            const notif = JSON.parse(message.body);
            showNotification(notif);
        });
    }, (error) => {
        console.error('Connection error:', error);
        updateConnectionState(false);
        showStatus('Connection failed. Is the server running?', 'error');
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect(() => {
            updateConnectionState(false);
            showStatus('Disconnected', 'neutral');
        });
    } else {
        updateConnectionState(false);
    }
}

function updateConnectionState(isConnected, userId = '') {
    const btnConnect = document.getElementById('btnConnect');
    const btnDisconnect = document.getElementById('btnDisconnect');
    const inputUserId = document.getElementById('userId');
    const statusDot = document.getElementById('statusDot');
    const statusText = document.getElementById('statusText');
    const btnDemo = document.getElementById('btnDemo');

    if (isConnected) {
        btnConnect.classList.add('hidden');
        btnDemo.classList.add('hidden');
        btnDisconnect.classList.remove('hidden');
        inputUserId.disabled = true;
        statusDot.classList.add('connected');
        statusText.innerText = `Connected as ${userId}`;
        statusText.style.color = 'var(--success-color)';
    } else {
        btnConnect.classList.remove('hidden');
        btnDemo.classList.remove('hidden');
        btnDisconnect.classList.add('hidden');
        inputUserId.disabled = false;
        statusDot.classList.remove('connected');
        statusText.innerText = 'Disconnected';
        statusText.style.color = 'var(--text-secondary)';
    }
}

function showNotification(notif) {
    const list = document.getElementById('notifList');
    const emptyState = document.getElementById('emptyState');

    if (emptyState) {
        emptyState.classList.add('hidden');
    }

    const li = document.createElement('li');
    li.className = 'notification-item';

    const time = new Date().toLocaleTimeString();

    li.innerHTML = `
        <div class="notif-content">
            <div class="notif-header">
                <span>Channel ${notif.channelId}</span>
                <span>${time}</span>
            </div>
            <div class="notif-body">
                ${notif.message}
            </div>
        </div>
    `;

    // Add to top
    list.insertBefore(li, list.firstChild);
}

function showStatus(msg, type) {
    // Simple console log for now, can be upgraded to toast
    console.log(`[${type.toUpperCase()}] ${msg}`);
}
