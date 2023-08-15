# Changing Java Version in Gitpod

## Method 1: Using `.gitpod.yml` configuration file

1. Create or edit the `.gitpod.yml` file in the root directory of your Git repository if it doesn't already exist.

2. Add the following lines to the `.gitpod.yml` file to specify the desired Java version using the `init` command:

   ```yaml
   tasks:
     - init: |
         sdk use java 17.0.8-oracle
### Method 1: Using `.gitpod.yml` Configuration File

1. Save the `.gitpod.yml` file in the root directory of your Git repository.

2. When a Gitpod workspace based on this repository starts, it will automatically execute the specified command to set the desired Java version to `17.0.8-oracle`.

### Method 2: Using the Terminal

1. Open the Gitpod workspace.

2. In the terminal, use the following commands to update the Java version:

   ```bash
   # List available Java versions
   sdk list java

   # Install and set the desired Java version
   sdk install java 17.0.8-oracle
   sdk use java 17.0.8-oracle


# List available Java versions
sdk list java

# Install and set the desired Java version
sdk install java 17.0.8-oracle
sdk use java 17.0.8-oracle

### Sharing Your Workspace

1. Open your workspace in Gitpod.

2. In the bottom left corner of the Gitpod VS Code environment, locate the "Share" button.

3. Click on the "Share" button to open the sharing options.

4. In the sharing options, you will see a toggle to make your workspace shareable. Toggle this option to enable sharing.

5. Once sharing is enabled, a shareable URL will be generated. Click on the "Copy" button next to the URL to copy it to your clipboard.

6. Share this URL with anyone you want to provide access to your Gitpod workspace. They will be able to view and interact with your workspace environment using the provided URL.

Remember that shared workspaces can be read-only or read-write, depending on the settings you choose when generating the shareable link. This allows you to control the level of access others have to your workspace.

Please note that shared workspace links are temporary and can expire, depending on your Gitpod plan and configuration.
