# Svg to Compose - Docker

<p align="center">
    <img alt="Docker Pulls" src="https://img.shields.io/docker/pulls/sergioribera/svg2compose">
    <img alt="Docker Image Size with architecture (latest by date/latest semver)" src="https://img.shields.io/docker/image-size/sergioribera/svg2compose">
</p>

This is a project that tries to pack in a small container all the necessary and required to run a script that allows in a single command to convert a folder of svg files into a package of icons for compose using the [svg2compose](https://github.com/DevSrSouza/svg-to-compose) project.

## Version
This project is based on the kotlin versions it uses inside to run the project.

## Usage
For the moment it is necessary to indicate a volume for the source and for output

```bash
Usage:
  -s, --source        Source folder name (default: /source)
  -o, --output        Destination folder name (default: /out)
  -n, --name          Accessor Name (default: AppIcons)
  -p, --package       Icons package to create (default: icons)
  -a, --all-name      Name for all assets (default: AllIcons)
      --svg           Set vector type to SVG (default)
      --drawable      Set vector type to DRAWABLE
```

This will create a folder with the name of the parameter -p/--package which currently defaults to icons and there will be all the converted files.

```
-v "/my/computer/path:/docker/container/path"
-v "$(pwd)/assets:/source"
```

```sh
docker run --rm -it -v "$HOME/super_clipboard/assets:/source" -v "$(pwd):/out" sergioribera/sv2compose:1.9.0 --svg
```
