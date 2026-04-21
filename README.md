## JADX DECOMPILE
A docker image workflow to decompile android apk files.

> [!NOTE]
> The image builds for both `linux/amd64` and `linux/arm64` automatically via BuildKit's `TARGETARCH`. No Dockerfile edits are required.

### Toolchain
- Python 3.13 (slim)
- Eclipse Temurin JDK 21.0.10+7 (SHA256 verified)
- JADX 1.5.5 (SHA256 verified)

## Setup and Usage

1. Clone the repository
    ```plaintext
    git clone https://github.com/dev-rvk/jadx_decompile.git
    ```
2. Build the image
   ```plaintext
   docker build -t jadx-decompile .
   ```
3. Run the image (make sure the APK is in the `uploads/` directory)
   ```plaintext
   docker run -v ./uploads:/app/uploads -v ./output:/app/output jadx-decompile <name-of-apk>.apk
   ```
   Example:
   ```plaintext
   docker run -v ./uploads:/app/uploads -v ./output:/app/output jadx-decompile test.apk
   ```
4. The decompiled sources will be written to `output/<name-of-apk>/`.

### Bumping versions
All pinned versions and checksums live as `ARG` entries at the top of the `Dockerfile`. To upgrade JADX or the JDK, bump the version and replace the matching SHA256.
