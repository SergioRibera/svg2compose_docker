# Svg to Compose - Docker

<p align="center">
    <img alt="Docker Pulls" src="https://img.shields.io/docker/pulls/sergioribera/svg2compose">
    <img alt="Docker Image Size with architecture (latest by date/latest semver)" src="https://img.shields.io/docker/image-size/sergioribera/svg2compose">
</p>
This is a project that tries to pack in a small container all the necessary and required to run a script that allows in a single command to convert a folder of svg files into a package of icons for compose using the [svg2compose](https://github.com/DevSrSouza/svg-to-compose) project.

## Version
This project is based on the kotlin versions it uses inside to run the project.

## Usage
```bash
Usage:
  -s, --source        Source folder name
  -o, --output        Destination folder name
  -n, --name          Accessor Name (default: AppIcons)
  -p, --package       Icons package to create (default: icons)
  -a, --all-name      Name for all assets (default: AllIcons)
      --svg           Set vector type to SVG
      --drawable      Set vector type to DRAWABLE
```

```sh
docker run --rm -it sergioribera/sv2compose:latest -s ./svg_icons -o src/com/sergioribera/superclipboard/ui
```
