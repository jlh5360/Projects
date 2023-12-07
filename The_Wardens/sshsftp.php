<?php 
    $page = 'SSH and SFTP';
    $css = 'subpage.css';
    $script = '';
    include 'assets/inc/header_&_nav.php';
?>

        <div class="content">
            <h1>SSH and SFTP</h1>

            <section id="ssh">
                <h2>SSH</h2>
                <p>
                    Secure Shell or Secure Socket Shell (SSH) is a network protocol that gives users a secure way to access
                    a computer over an unsecured network. SSH provides alternate options for strong authentication, and
                    protects the communications security and integrity with strong encryption. It was created to replace
                    insecure terminal emulation. It also replaces file transfer programs. SSH builds safe channels between
                    local and remote computers making it ideal for web developers.

                </p>

                <h3>Why is it Important?</h3>

                <p>
                    SSH enables a secure remote connection between two systems. </p>
                <p>
                    SSH protocol works in the client-server model, meaning that a connection is established by the SSH
                    client connecting to the SSH server. The SSH client uses a public key cryptography to verify the
                    identity of the SSH server. After that is confirmed, it is now okay for the client to exchange
                    information between the server.
                </p>

                <h3>Keys</h3>

                <p>
                    There are many advantages of using a key-bases authentication system. One of the benefits of using a
                    key-based authentication is security. The user must generate a key that is unique to them. These keys
                    use an asymmetric encryption algorithm which adds another layer of safety. Using a key also means that
                    the user does not need to memorize complicated passwords. Passwords can be easy to be guessed using
                    one’s personal information or can be broken into with brute force.
                </p>
            </section>

            <section id="sftp">
                <h2>SFTP</h2>

                <p>
                    Secure File Transfer Protocol (SFTP) is a secure version of File Transfer Protocol (FTP) and is part of
                    the SSH protocol. This allows for easy data transfer and access over an SSH data stream. SFTP works by
                    using a secure shell data stream. It establishes a secure connection and then provides a higher level of
                    protection for data while transferring it. It uses different encryptions that help move the data and
                    ensure that data is unread, which is being processed.


                </p>

                <h3>Ports</h3>

                <p>
                    A port is a virtual point where network connections start and end. Ports are software-based and managed
                    by a computer's operating system. Each port is associated with a specific process or service. Ports
                    allow computers to easily differentiate between different kinds of traffic: emails go to a different
                    port than webpages, for instance, even though both reach a computer over the same Internet connection.
                </p>
            </section>
        </div>

<?php
    include 'assets/inc/footer.php';
?>