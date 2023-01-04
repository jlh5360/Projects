<?php
$page = 'Basic Commands';
$css = 'basic_commands_styles.css';
$script = 'totop.js';
include 'assets/inc/header_&_nav.php';
?>


<div id="content">

    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
    <h1>Basic Commands</h1>

    
    <ul id="subnav">
        <li class="sub"><a href="#ls">ls</a></li>
        <li class="sub"><a href="#cat">cat</a></li>
        <li class="sub"><a href="#cd">cd</a></li>
        <li class="sub"><a href="#chmod">chmod</a></li>
        <li class="sub"><a href="#mkdir">mkdir</a></li>
        <li class="sub"><a href="#rmdir">rmdir</a></li>
        <li class="sub"><a href="#cp">cp</a></li>
    </ul>

    <div id="section">
        <div id="ls">
            <h2>ls</h2>

            <ul>
                <li>The “ls” command lists the files and directories in your current directory</li>
                <li>The “ls -R” command shows all the files in both directories and subdirectories</li>
                <li>The “ls -a” command lists all items (files or directory) including hidden ones that start with a “.” (period); note that any file or directory starting with a “.” will not be seen unless you request for it.</li>
                <li>The “ls -al” details information about the files in a columnar format</li>
            </ul>

            <table>
                <tr>
                    <th><strong>Column #</strong></th>
                    <th><strong>Description</strong></th>
                </tr>

                <tr>
                    <th>1</th>
                    <th>File type and access permissions</th>
                </tr>

                <tr>
                    <th>2</th>
                    <th>Number of HardLinks to the file</th>
                </tr>

                <tr>
                    <th>3</th>
                    <th>Owner and the creator of the file</th>
                </tr>

                <tr>
                    <th>4</th>
                    <th>Usergroup / Group of the owner</th>
                </tr>

                <tr>
                    <th>5</th>
                    <th>File size in Bytes</th>
                </tr>

                <tr>
                    <th>6</th>
                    <th>Date & Time</th>
                </tr>

                <tr>
                    <th>7</th>
                    <th>Directory or File name</th>
                </tr>
            </table>
        </div><br>

        <div id="cat">
            <h2>cat</h2>
            <p>
                The “cat” server command is used for a couple of different ways such as to: display, copy, combine,
                and create new text files. Follow the examples below on how to use this command for the previously
                stated purposes.
            </p>

            <p><strong>Creating a new file:</strong></p>
            <ol>
                <li>cat > filename</li>
                <li>Add content</li>
                <li>Press “ctrl + d” to return to command prompt</li>
            </ol>

            <p><strong>Displaying a file:</strong></p>
            <ol>
                <li>cat filename</li>
                <li>cat file1 file 2 (this will display those files one after the other, catenating their contents to standard output)</li>
            </ol>

            <p><strong>Copying & Combining 2 files:</strong></p>
            <ol>
                <li>cat filename > newfilename (copying)</li>
                <li>cat file1 file2 > newfilename (combining)</li>
            </ol>

            <p><u>Both</u></p>
            <p>
                Note that the “cat” command sends its output to stdout (standard output), which is
                usually the terminal screen; however, you can redirect the output to a file by using
                the shell redirection symbol “>”.
            <p>

            <p><u>Copying</u></p>
            <p>
                Normally, you would use the “cp” command to copy a file, but as
                stated before, you can also use the “cat” command to make a copy.
            <p>

            <p><u>Combining</u></p>
            <p>
                As soon as you enter this command (of course with your appropriate filenames), the files are
                concatenated (linked together), but you do not see a result; this is due to the Bash Shell
                (Terminal) being a silent type. Shell Commands will never give a confirmation message if the
                command has been successfully executed, and it only shows a message when an error has occurred
                or when something goes wrong.
            <p>
        </div><br>

        <div id="cd">
            <h2>cd</h2>
            <p>The cd command is used to change the current working directory</p>
            <p>Jump to the home directory with “cd” </p>
            <p>enter a directory with “cd directoryName”</p>
            <p>Change your current working directory with “cd .”</p>
        </div><br>

        <div id="chmod">
            <h2>chmod</h2>
            <p>The chmod command allows you to change the permissions on a file using either symbolic or numeric mode. We’ll cover both.</p><br>
            <p>The syntax of the chmod command when using the symbolic mode has the following format:</p><br>
            <p>Chmod [ugoa…][-+=]perms…[,…] FILENAME</p><br>
            <p>The first set of flags ([ugoa]) defines which user classes that the permissions to the file are changed.</p><br>

            <ul>
                <li>u - The file owner.</li>
                <li>g - The users who are members of the group.</li>
                <li>o - All other users.</li>
                <li>a - All users, identical to ugo.</li>
            </ul><br>

            <p>If the user flag is omitted, the default one is a.</p><br>
            <p>The operation flags ([-+=]), the second set of flags, defines whether the permissions are to be removed, added, or set:</p><br>

            <ol>
                <li>- Removes the specified permissions.</li>
                <li>+ Adds specified permissions.</li>
                <li>= Changes the current permissions to the specified permissions. If no permissions are specified after the = symbol, all permissions from the specified user class are removed.</li>
            </ol><br>

            <p>
                The permissions (perms...) can be explicitly set using either zero or one or
                more of the following letters: r, w, x, X, s, and t. Use a single letter from
                the set u, g, and o when copying permissions from one to another user's class.
            </p><br>

            <p>Examples:</p>
            <p>Remove the read, write, and execute permission for all users except the file’s owner:</p>
            <p>chmod og-rwx filename</p>
            <p>Remove the execute permission for all users:</p>
            <p>chmod a-x filename</p>
            <p>Give the members of the group permission to read the file, but not to write and execute it:</p>
            <p>chmod g=r filename</p>
            <p>The syntax of the chmod command when using numeric method has the following format:</p>
            <p>chmod NUMBER FILE...</p>
            <p>When using the numeric mode, you can set the permissions for all three user classes (owner, group, and all others) at the same time.</p>
            <p>The NUMBER can be a 3 or 4-digit number.</p>
            <p>When a 3 digit number is used, the first digit represents the permissions of the file’s owner, the second one the file’s group, and the last one all other users.</p>
            <p>Each write, read, and execute permissions have the following number value:</p>
            <ul>
                <li>r (read) = 4</li>
                <li>w (write) = 2</li>
                <li>x (execute) = 1</li>
                <li>no permissions = 0</li>
            </ul>

            <p>The permissions number of a specific user class is represented by the sum of the values of the permissions for that group.</p>
            <p>
                To find out the file’s permissions in numeric mode simply calculate the totals for all users classes. For example, to give read,
                write and execute permission to the file’s owner, read and execute permissions to the file’s group and only read permissions to
                all other users you would do the following:
            </p>

            <ul>
                <li>Owner: rwx=4+2+1=7</li>
                <li>Group: r-x=4+0+1=5</li>
                <li>Others: r-x=4+0+0=4</li>
            </ul>

            <p>Using the method above we come up to the number 754, which represents the desired permissions.</p>
            <p>Here are some examples of how to use the chmod command in numeric mode:</p>
            <p>Give the file’s owner read and write permissions and only read permissions to group members and all other users:</p>
            <p>chmod 644 dirname</p>
            <p>Give the file’s owner read, write and execute permissions, read and execute permissions to group members and no permissions to all other users:</p>
            <p>chmod 750 dirname</p>
        </div><br>

        <div id="mkdir">
            <h2>mkdir</h2>
            <p>The command that lets you make folders or “directories” is mkdir.</p>
            <p>To create a directory in Linux, pass the directory’s name as the argument to the mkdir command. To create a new directory mydir, run: mkdir mydir</p>
            <p>You can see that the directory was made by listing the contents of the directory using the ls -l in your command line.</p>
        </div><br>

        <div id="rmdir">
            <h2>rmdir</h2>
            <p>rmdir is a command used for deleting empty directories. It is useful when you only want to delete a directory that is empty, without having to check whether the directory is empty.</p>
            <p>To delete an empty directory named mydir you would type:</p>
            <p>rmdir mydir</p>
            <p>If the directory is not empty, you will get the following error:</p>
            <p>rmdir: failed to remove ‘mydir’: No such file or directory</p>
            <p>If it is not empty, you will need to use the rm command or manually remove the directory contents before you can delete it.</p>

            <p>

            </p>
        </div><br>

        <div id="cp">
            <h2>cp</h2>
            <p>To copy files and directories on linux/unix, you can use the cp command.</p>
            <p>cp source destination</p>
            <p>The source can contain one or more files or directories as arguments, and the destination argument can be a single file or directory.</p>
            <p>To copy files and directories, you must have read permissions on the source file and write permission on the destination directory. Otherwise you will see a permission denied error.</p>
        </div><br>
    </div>
</div>

<?php
include 'assets/inc/footer.php';
?>