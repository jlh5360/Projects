<?php 
    $page = 'Permissions';
    $css = 'permissions_styles.css';
    $script = '';
    include 'assets/inc/header_&_nav.php';
?>

        <div id="content">
            <h1>Permissions</h1>

            <div id="section">
                <div id="ownership">
                    <h2>Ownership</h2>
                    <table>
                        <tr>
                            <th><strong>Owner Types</strong></th>
                            <th><strong>Description</strong></th>
                        </tr>

                        <tr>
                            <th>User</th>
                            <th>A user is the owner of the file and, by default, the creator of the file is its owner</th>
                        </tr>

                        <tr>
                            <th>Group</th>
                            <th>A user-group can be of multiple users where all users belonging to a group will have the same permissions of a file.  Rather than assigning permissions to each user, you can add all desired users to a group and assign the group certain permissions to a file.</th>
                        </tr>

                        <tr>
                            <th>Other</th>
                            <th>Basically means everybody else or any other user who has access to a file (did not create the file non belongs to a user-group)</th>
                        </tr>
                    </table>
                </div><br>

                <div id="permissions">
                    <h2>Permissions</h2>
                    <table>
                        <tr>
                            <th><strong>File Permissions</strong></th>
                            <th><strong>Description</strong></th>
                        </tr>

                        <tr>
                            <th>Read</th>
                            <th>Gives you the authority/ability to open and read/view a file, and allows you to list the content of a directory/folder</th>
                        </tr>

                        <tr>
                            <th>Write</th>
                            <th>Gives you the authority/ability to modify the contents of a file; similarly to files, you are allowed to modify a directory to: add/delete, move/remove, and rename files that are stored</th>
                        </tr>

                        <tr>
                            <th>Execute</th>
                            <th>This permission allows you to run the program code.  If this execute permission is not set, then you would not be able to run it; however, you might still be able to see and or edit the program code (provided read and write permissions are set)</th>
                        </tr>
                    </table>
                </div><br><br>

                <p>Let’s see the file permissions by using the command “ls -l”</p>
                <p>The first “-” of the permissions implies that we have selected a file; but, if it was a directory, then a “<strong>d</strong>” would have been shown.</p>
                <p>In short these characters represent the following below:</p>

                <table>
                    <tr>
                        <th><strong>Character</strong></th>
                        <th><strong>Description</strong></th>
                    </tr>

                    <tr>
                        <th><strong>d</strong></th>
                        <th>It’s a directory</th>
                    </tr>

                    <tr>
                        <th><strong>r</strong></th>
                        <th>Read permission</th>
                    </tr>

                    <tr>
                        <th><strong>w</strong></th>
                        <th>Write permission</th>
                    </tr>

                    <tr>
                        <th><strong>x</strong></th>
                        <th>Execute permission</th>
                    </tr>

                    <tr>
                        <th><strong>-</strong></th>
                        <th>No permission</th>
                    </tr>
                </table>

                <h2>Changing file/directory permissions</h2>
                <p>The “chmod” (change mode) command is used to set permissions (read, write, execute) on a file or directory for the owner, group, and other (also can be known as the world).</p>

                <p><strong>Syntax:</strong></p>
                <p>chmod permissions filename</p><br>

                <p>There are 2 ways to use this command:</p>
                <ol>
                    <li><strong>Absolute mode</strong></li>
                    <li><strong>Symbolic mode</strong></li>
                </ol><br><br>


                <h2>Absolute (Numeric) Mode</h2>
                <table>
                    <tr>
                        <th><strong>Number</strong></th>
                        <th><strong>Permission Type</strong></th>
                        <th><strong>Symbol</strong></th>
                    </tr>

                    <tr>
                        <th>0</th>
                        <th>No permissions</th>
                        <th>-</th>
                    </tr>

                    <tr>
                        <th>1</th>
                        <th>Execute</th>
                        <th>-x</th>
                    </tr>

                    <tr>
                        <th>2</th>
                        <th>Write</th>
                        <th>-w-</th>
                    </tr>

                    <tr>
                        <th>3</th>
                        <th>Execute + Write</th>
                        <th>-wx</th>
                    </tr>

                    <tr>
                        <th>4</th>
                        <th>Read</th>
                        <th>r--</th>
                    </tr>

                    <tr>
                        <th>5</th>
                        <th>Read + Execute</th>
                        <th>r-x</th>
                    </tr>

                    <tr>
                        <th>6</th>
                        <th>Read + Write</th>
                        <th>rw-</th>
                    </tr>

                    <tr>
                        <th>7</th>
                        <th>Read + Write + Execute</th>
                        <th>rwx</th>
                    </tr>
                </table><br><br>


                <h2>Symbolic Mode</h2>
                <table>
                    <tr>
                        <th><strong>Operator</strong></th>
                        <th><strong>Description</strong></th>
                    </tr>

                    <tr>
                        <th>+</th>
                        <th>Adds a permission to a file or directory</th>
                    </tr>

                    <tr>
                        <th>-</th>
                        <th>Removes the permission</th>
                    </tr>

                    <tr>
                        <th>=</th>
                        <th>Sets the permission and overrides the permissions set earlier</th>
                    </tr>
                </table><br><br<>

                <p>The various owners are represented as:</p>
                <table>
                    <tr>
                        <th><strong>User</strong></th>
                        <th><strong>Dentations</strong></th>
                    </tr>

                    <tr>
                        <th>u</th>
                        <th>user/group</th>
                    </tr>

                    <tr>
                        <th>g</th>
                        <th>group</th>
                    </tr>

                    <tr>
                        <th>o</th>
                        <th>other</th>
                    </tr>

                    <tr>
                        <th>a</th>
                        <th>all</th>
                    </tr>
                </table><br><br>


                <h2>Changing Ownership and Group</h2>
                <p>Changing the ownership of a file/directory uses the “chown” command as followed</p>
                <p><strong>Syntax:</strong></p>
                <p>chown user filename</p>
                <p>If you want to change the user as well as group for a file or directory, use this syntax as followed</p>

                <p><strong>Syntax:</strong></p>
                <p>chown user:group filename</p>
                <p>If you want to change the group-owner only, use the “chgrp” (change group) command as followed</p>

                <p><strong>Syntax:</strong></p>
                <p>chgrp group_name filename</p>
            </div>
        </div>

<?php
    include 'assets/inc/footer.php';
?>