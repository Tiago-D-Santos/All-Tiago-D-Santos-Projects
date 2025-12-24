
import socket

client = socket.socket(socket.AF_BLUETOOTH, socket.SOCK_STREAM, socket.BTPROTO_RFCOMM)
client.connect(("3c:21:9c:a7:9b:b6", 4))

try:
    while True:
        message = input("Enter message: ")
        client.send(message.encode("utf-8"))
        data = client.recv(1024)
        if not data:
            break
        print("Received message:", data.decode('utf-8'))
except OSError as e:
    pass

client.close()

