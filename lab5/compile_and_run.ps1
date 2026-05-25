$jdk = "C:\Program Files\Eclipse Adoptium\jdk-25.0.3.9-hotspot\bin"
$srcFiles = Get-ChildItem -Recurse src -Filter "*.java" | Select-Object -ExpandProperty FullName
& "$jdk\javac.exe" -d out $srcFiles
if ($LASTEXITCODE -eq 0) {
    & "$jdk\java.exe" -cp out Main
}
