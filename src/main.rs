use std::net::{TcpListener, TcpStream};
use std::io::{Read, Write};
use std::thread;
use rusqlite::{Connection, Result};

const DB_NAME: &str = "server.db";

fn handle_client(mut stream: TcpStream, db_conn: Connection) -> Result<()> {
    let mut buffer = [0; 512];
    loop {
        match stream.read(&mut buffer) {
            Ok(0) => break,
            Ok(x) => {
                let received_msg = String::from_utf8_lossy(&buffer[..x]).to_string();
                println!("Received: {}", received_msg);
                db_conn.execute("INSERT INTO messages (message) VALUES (?1)", &[&received_msg]).unwrap();
                stream.write_all(b"Hello from server!").unwrap();
            }
            Err(e) => {
                eprintln!("Failed to read from socket: {}", e);
                break;
            }
        }
    }
    Ok(())
}

fn ensure_created() {
    let conn = Connection::open(DB_NAME).unwrap();
    conn.execute(
        "CREATE TABLE IF NOT EXISTS messages (
             id INTEGER PRIMARY KEY,
             message TEXT NOT NULL
         )",
        [],
    ).expect("Failed to initialize db");
}

fn main() -> std::io::Result<()> {
    let listener = TcpListener::bind("0.0.0.0:12345")?;
    println!("Server listening on port 12345");
    ensure_created();
    
    for stream in listener.incoming() {
        match stream {
            Ok(stream) => {
                println!("New connection: {}", stream.peer_addr().unwrap());
                thread::spawn(move || {
                    let db_conn = Connection::open(DB_NAME).unwrap();
                    handle_client(stream, db_conn).unwrap_or_else(|err| {
                        eprintln!("Error handling client: {}", err);
                    });
                });
            }
            Err(e) => {
                eprintln!("Failed to accept connection: {}", e);
            }
        }
    }

    Ok(())
}
