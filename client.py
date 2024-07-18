import socket

SERVER_IP = '192.168.7.2'
SERVER_PORT = 12345

def send_message(message):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        try:
            s.connect((SERVER_IP, SERVER_PORT))
            print(f"Connected to {SERVER_IP}:{SERVER_PORT}")
            s.sendall(message.encode())
            response = s.recv(1024)
            print(f"Received: {response.decode()}")

        except Exception as e:
            print(f"Error: {e}")

if __name__ == '__main__':
    message = "Hello from Python!"
    send_message(message)