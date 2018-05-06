import socket
import threading
import json
import time


sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

sock.bind(('0.0.0.0', 10000))

sock.listen(1)
datas = []
connections = []
sent = 0;
start = time.time()


def handler(c,a):
    while True:
        global connections
        global sent
        data = c.recv(1024)
        data_string = str(data, 'utf-8')
        if data:
            parse_json = json.loads(data_string)
            parse_json.update()
            datas.append(parse_json)

            print(len(connections))
            print(sent)
            if sent <= 1000:
                sendData(datas)
                sent = sent + 1
                print("Mensaje Mandado")
                if sent == 1000:
                    print("--- %s seconds ---" % (time.time() - start))
        if not data:
            c.close()
            break


def sendData(data):
    print(str(datas) + "\n")
    connections[len(connections)-1].send(bytes(str(datas).replace("'",'"') + "\n", 'utf-8'))




while True:
    c, a = sock.accept()
    cThread = threading.Thread(target=handler, args=(c,a))
    cThread.daemon = True
    cThread.start()
    connections.append(c)
    print(connections)

