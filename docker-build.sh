name="demo"

# Look for a line akin to: "version - '0.0.1-SNAPSHOT'"
# Only take the '0.0.1-SNAPSHOT' part
version=$(cat build.gradle | grep "version = " | cut -d" " -f3)

# Remove quotes
version="${version%\'}"
version="${version#\'}"

tag="$name:$version"

echo "Building image: $tag"

docker build -t $tag --build-arg name="$name" --build-arg version="$version" .
