import socket

# Third-party library for Bluetooth support (e.g., pybluez)
# import bluetooth

server = socket.socket(socket.AF_BLUETOOTH, socket.SOCK_STREAM, socket.BTPROTO_RFCOMM)

# Bluetooth adapter MAC address: 3c:21:9c:a7:9b:b6
# 2:4 = Channel
server.bind(("3c:21:9c:a7:9b:b6", 4))

# Just allow one connection at a time
server.listen(1)

try:
    client, addr = server.accept()
    while True:
        data = client.recv(1024)
        # If we don't receive anything
        if not data:
            break
        print(f"Message: {data.decode('utf-8')}")
        message = input("Enter Message:")
        client.send(message.encode("utf-8"))
except OSError as e:
    pass
finally:
    client.close()
    server.close()

print("Finished")








