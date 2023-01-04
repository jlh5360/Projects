<?php 
    $page = 'The Terminal';
    $css = 'subpage.css';
    include 'assets/inc/header_&_nav.php';
?>

        <div class="content">
            <h1>The Terminal</h1>

            <section id="geninfo">
                <p>
                    The terminal is an interface for you to execute text-based commands, and it gives you direct access to
                    the underlying operating system, via a shell, on your Mac. A long time ago, before computers had
                    graphical user interfaces (GUIs), the only way to operate a computer was through the command line.
                    Needing to run the computer through the command line helped users better understand what was going on
                    inside their computer.
                </p>

                <p>
                    Often referred to as the shell, terminal, console, prompt or various other names, it can give the
                    appearance of being complex and confusing to use. Unix was the first to use the terminal. It was used
                    to connect users remotely to the system. When logged into a Unix mainframe via a terminal users still
                    had to manage the sort of file management tasks that you might now perform with a mouse and a couple of
                    windows. Whether creating files, renaming them, putting them into subdirectories, or moving them around
                    on disk, users in the 70s could do everything entirely with a textual interface.
                </p>
            </section>
        </div>

<?php
    include 'assets/inc/footer.php';
?>